

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  
         String vcodigo="";
          String vnome="";
          String vtipo="";
          String vteor="";
          String vano="";
          String vmarca="";
          
       
         vcodigo = (String) request.getAttribute("Acodigo").toString();
         vnome    = (String) request.getAttribute("Anome").toString();
         vtipo   = (String) request.getAttribute("Atipo").toString();
         vteor   = (String) request.getAttribute("Ateor").toString();
         vano   = (String) request.getAttribute("Aano").toString();
         vmarca   = (String) request.getAttribute("Amarca").toString();
        
    %>
    <body>
        <%@include file="menu.jsp" %>
        
        <header>
            <h3 class="h3 text-center" >Alterar este Aluno?</h3><br/>
        </header>
        
        <div class="col-md-offset-4 col-md-4">
            <div class="well well-lg"> 
        
                <form name="form" action="ServletAlterarCerveja" method="post">
                     Código do aluno: <span class="badge"> <%=vcodigo%></span>
                    <input type="hidden" name="codigo" value="<%=vcodigo%>">
                    <br/>
                    
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome:</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span> 
                            </div>   
                            <input type="text" name="nome" value="<%=vnome%>" class="form-control" id="nome">  
                        </div>
                    </div>
                  
                                          
                    <div class="form-group">
                        <label class="control-label" for="tipo">Tipo:</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="text" name="tipo" value="<%=vtipo%>" class="form-control" id="tipo">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label" for="teor">Teor:</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="number" name="teor" value="<%=vteor%>" class="form-control" id="teor">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label" for="tipo">Ano:</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="number" name="ano" value="<%=vano%>" class="form-control" id="ano">
                        </div>
                    </div>
                        
                        
                         <div class="form-group">
                        <label class="control-label" for="tipo">Marca:</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="text" name="marca" value="<%=vmarca%>" class="form-control" id="marca">
                        </div>
                    </div>
                        
                        
                   <input type="submit" value="Alterar" class="btn btn-info">
                </form>
            </div>
        </div>
        
    </body>
</html>