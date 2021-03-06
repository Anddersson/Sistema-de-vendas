/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.binary.work.helpers.Notificacao;
import br.com.binary.work.models.GeneroModel;
import br.com.binary.work.services.GeneroService;

@WebServlet(name = "GeneroControllerServlet", urlPatterns = {"/autenticado/Generos"})
public class GeneroControllerServlet extends HttpServlet {

    private final GeneroService service = new GeneroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String acao = request.getParameter("acao");

            if (acao == null || acao.equals("")) {
                acao = "listar";
            }

            switch (acao) {
                case "listar":
                    listarGenero(request, response);
                    break;
                case "alterar":
                    carregarGenero(request, response);
                    break;
                case "salvar":
                    criarGenero(request, response);
                    break;
                default:
                    listarGenero(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String acao = request.getParameter("acao");

            switch (acao) {
                case "salvar":
                    incluirGenero(request, response);
                    break;
                case "alterar":
                    alterarGenero(request, response);
                    break;
                case "excluir":
                    excluirGenero(request, response);
                    break;
            }

        } catch (ServletException | IOException e) {
            throw new ServletException(e);
        }

    }

    protected void criarGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/autenticado/cadastroGenero.jsp").forward(request, response);
    }

    protected void incluirGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");

        GeneroModel genero = new GeneroModel(0, nome);

        try {
            List<Notificacao> notificacoes = service.incluirGenero(genero);
            if (notificacoes.isEmpty()) {
                request.setAttribute("statusSalvo", true);
                listarGenero(request, response);
            } else {
                request.setAttribute("notificacoes", notificacoes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/autenticado/cadastroGenero.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/erro.jsp");
            dispatcher.forward(request, response);
        } finally {
            service.limparNotificacoes();
        }
    }

    protected void listarGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("generos", service.obterListaGenero());
        request.getRequestDispatcher("/WEB-INF/jsp/autenticado/consultaGenero.jsp").forward(request, response);
    }

    protected void carregarGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idGenero"));
        GeneroModel genero = service.obterGeneroPorId(id);

        request.setAttribute("genero", genero);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/autenticado/alterarGenero.jsp");
        dispatcher.forward(request, response);
    }

    protected void alterarGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idGenero"));
        String nome = request.getParameter("nome");

        GeneroModel genero = new GeneroModel(id, nome);

        try {
            List<Notificacao> notificacoes = service.alterarGenero(genero);
            if (notificacoes.isEmpty()) {
                request.setAttribute("statusAlterado", true);
                listarGenero(request, response);
            } else {
                request.setAttribute("notificacoes", notificacoes);
                request.setAttribute("genero", genero);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/autenticado/alterarGenero.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/erro.jsp");
            dispatcher.forward(request, response);
        } finally {
            service.limparNotificacoes();
        }
    }

    protected void excluirGenero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        int id = Integer.parseInt(request.getParameter("idGenero"));
        GeneroModel genero = service.obterGeneroPorId(id);

        try {
            service.excluirGenero(genero);
            out.print(gson.toJson(genero));
            out.flush();
            out.close();
        } catch (Exception e) {
            out.print(gson.toJson(genero));
            out.flush();
            out.close();
        }
    }

}
