<%@page import="java.util.ArrayList"%>
<%@page import="br.com.controle.Cerveja"%>
<%@page import="br.com.modelo.ManterCerveja"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <!--Fontes do google-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    
    <!---->

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="style.css">

</head>
<body>
    
    <header class="header-container">
        <ul>
            <li><a href="form.jsp">Cadastrar</a></li>
            <li><a href="listar.jsp">Listar produtos</a></li>
        </ul>
    </header><!--Cabeçalho de navegação-->

    <main class="container-geral-listar">
        <div class="corpo-table">
        <table>
            <thead>
                <tr>
                  <th scope="col">Codigo</th>
                  <th scope="col">Nome</th>
                  <th scope="col">Tipo</th>
                  <th scope="col">Teor</th>
                  <th scope="col">Ano</th>
                  <th scope="col">Marca</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
    </tr>
            </thead>
  
  
        <%
          String vcodigo="";
          String vnome="";
          String vtipo="";
          String vteor="";
          String vano="";
          String vmarca="";
          
         
          String vcontador="";
          
         
           ManterCerveja mc = new ManterCerveja();
           Cerveja ce = new Cerveja();
             ArrayList<Cerveja> nt = mc.pesquisarTudo();  
             
            for (int i = 0; i < nt.size(); i++) {                
                ce = nt.get(i);
              vcodigo= String.valueOf(ce.getCodigo());
              vnome = String.valueOf(ce.getNome());
              vtipo = String.valueOf(ce.getTipo());
              vteor = String.valueOf(ce.getTeor());
              vano = String.valueOf(ce.getAno());
              vmarca = String.valueOf(ce.getMarca());
              
             
               %>
              
            <tr>
              <th scope="row"><%=vcodigo%></th>
              <td><%=vnome%></td>
              <td><%=vtipo%></td>
              <td><%=vteor%></td>
              <td><%=vano%></td>
              <td><%=vmarca%></td>
              
           
            
              <td><a href="ServletEditarCerveja?codigo=<%=vcodigo%>" >Alterar</a>
              
              </td>
              <td>
                  <a href="ServletDeletar?codigo=<%=vcodigo%>" onclick="return confirm('Confirma exclusão do registro <%=vnome%>?')">excluir </a>   
                 
              </td>
            </tr>
          
            <%} 
        %>
         
        </table>
</html>
