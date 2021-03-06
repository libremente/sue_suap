<%
    String path = request.getContextPath();
    String url = path + "/pratica/comunicazione/azione/salva.htm";
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:url value="/download/pratica.htm" var="downloadPraticaUrl">
    <c:param name="id_pratica" value="${pratica.idPratica}"/>
</c:url>

<c:url value="/pratica/comunicazione/azione/salva.htm" var="submitEventoUrl">
</c:url>

<tiles:insertAttribute name="body_error" />

<script>
    $(document).bind('dragover', function(e) {
        var dropZoneall = $('#dropzoneall'),
                timeout = window.dropZoneTimeout;
        var dropZone = $('#dropzone');
        if (!timeout) {
            dropZoneall.addClass('in');
            dropZone.addClass('in');
        } else {
            clearTimeout(timeout);
        }
        var found = false,
                node = e.target;
        do {
            if (node === dropZone[0] || node === dropZoneall[0]) {
                found = true;
                break;
            }
            node = node.parentNode;
        } while (node != null);
        if (found) {
            dropZone.addClass('hover');
            dropZoneall.addClass('hover');
        } else {
            dropZone.removeClass('hover');
            dropZoneall.removeClass('hover');
        }
        window.dropZoneTimeout = setTimeout(function() {
            window.dropZoneTimeout = null;
            dropZone.removeClass('in hover');
            dropZoneall.removeClass('in hover');
        }, 100);
    });
</script>


<script>
    var idPratica = '${pratica.idPratica}';
    var idEvento = '${processo_evento.idEvento}';

    function isGiorniScadenzaValid(value) {
        if (value.length === 0) {
            return false;
        }
        var intValue = parseInt(value);
        if (intValue === Number.NaN) {
            return false;
        }
        if (intValue <= 0) {
            return false;
        }
        return true;
    }
    $(document).ready(function() {
        $(".collapsibleContent").hide();
        /*$(".collapsibleContentHeader").click(function() {
         $(this).next(".collapsibleContent").toggle('blind');
         });*/
        $("#creazioneEventoForm").submit(function() {
            var obbligatori = $('.obbligatorio').length;
            errorfile = false;
            for (var i = 0; i < obbligatori; i++) {
                var ob = $('.obbligatorio')[i];
                //^^CS AGGIUNTA
                //******************************************************************************************************
                //AGGIUNTO DA GAB MON 
                //******************************************************************************************************
                //e' stato necessario modificare sensibilmente questo messaggio di errore in modo che non controllasse che i file venissero caricati   
//                var file = $('.fileObbligatorio')[i].value;
                if ((ob.value == undefined || ob.value == ''))
                        // come era prima // || (file== undefined || file== ''))
                        {
                            errorfile = true;
                        }
            }
            if (errorfile)
            {
                //Per ogni file immattere una descrizione e caricare il file
                alert("Per ogni file caricato è obbligatorio immettere una descrizione.");//TODO: ^^CS message
                return false;
            }
            if ($('#giorniScadenzaCustom').length == 1) {
                if (!isGiorniScadenzaValid($('#giorniScadenzaCustom').val())) {
                    alert("Inserire un valore corretto per i giorni scadenza");
                    return false;


                }
            }
        });
    });

    function gestionePostaOrdinari(destinatario) {
        if ($(".ordinariaDiv").length > 0) {
            var id = "tr" + $(".ordinariaDiv tr").lenght;
            $(".ordinariaDiv").show();
            var tr = $(".ordinariaDiv #tr").clone();
            tr.attr("id", id);
            $(".ordinariaDiv table").append(tr);
            $(".ordinariaDiv #" + id + " .ordinariaNominativo").text(destinatario.description);
            $(".ordinariaDiv #" + id + " .ordinariaEmail").text(destinatario.email);
            tr.show();
        }
    }

    function disableSubmit()
    {
        var submit = document.getElementById("creaEvento");
        submit.disabled = true;
        return false;
    }


    function enableSubmit()
    {
        var submit = document.getElementById("creaEvento");
        submit.disabled = false;
        return false;
    }
</script>

<h2 class="short" style="text-align:left">${processo_evento.desEvento}</h2>

<div class="content_sidebar">
    <div class="sidebar_left">
        <h3><spring:message code="pratica.comunicazione.dettaglio.identificativo"/> <strong>${pratica.identificativoPratica}</strong></h3>
        <div class="sidebar_elemento">
            ${pratica.oggettoPratica}
            <p><strong><spring:message code="pratica.comunicazione.evento.pratica.dataricezione"/>:</strong> <fmt:formatDate pattern="dd/MM/yyyy" value="${pratica.dataRicezione}" /></p>
            <p><strong><spring:message code="pratica.comunicazione.evento.pratica.stato"/>:</strong> ${pratica.idStatoPratica.descrizione}</p>
            <c:choose>
                <c:when test="${not empty pratica.idModello}">
                    <p style="margin-top:20px;">
                        <a href="${downloadPraticaUrl}" class="scarica" target="_blank">
                            <spring:message code="pratica.comunicazione.evento.pratica.download"/>
                        </a>
                    </p>
                </c:when>
                <c:otherwise>
                    <span class="value"><spring:message code="pratica.comunicazione.evento.pratica.nofile"/></span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="sidebar_center">
        <form:form id="creazioneEventoForm" action="${submitEventoUrl}" class="uniForm inlineLabels comunicazione" method="post" enctype="multipart/form-data" commandName="comunicazione">
            <div class="page-control" data-role="page-control">
                <span class="menu-pull"></span> 
                <div class="menu-pull-bar"></div>
                <!-- Etichette cartelle -->
                <ul>  
                    <c:if test="${processo_evento.verso=='I'}">
                        <li <c:if test="${comunicazione.activeTab == '#frame4'}">class="active"</c:if>><a href="#frame4"><spring:message code="pratica.comunicazione.evento.mittenti"/></a></li>
                    </c:if>
                    <c:if test="${processo_evento.flgMail == 'S'}">
                        <li <c:if test="${comunicazione.activeTab == '#frame1'}">class="active"</c:if>><a href="#frame1"><spring:message code="pratica.comunicazione.evento.title"/></a></li>
                    </c:if>                        
                    	<li <c:if test="${comunicazione.activeTab == '#frame7'}">class="active"</c:if>><a href="#frame7"><spring:message code="pratica.comunicazione.template"/></a></li>
                    <c:if test="${processo_evento.flgProtocollazione == 'S'}">
                        <!--<li <c:if test="${comunicazione.activeTab == '#frame6'}">class="active"</c:if>><a href="#frame6"><spring:message code="pratica.comunicazione.evento.allegatoOriginale"/></a></li>-->
                    </c:if>
                    	<li <c:if test="${comunicazione.activeTab == '#frame5'}">class="active"</c:if>>
                        	<a href="#frame5"><spring:message code="pratica.comunicazione.evento.documento"/></a>
                    </li>
                    <c:if test="${processo_evento.flgScadenzeCustom == 'S'}">
                        <li <c:if test="${comunicazione.activeTab == '#frame2'}">class="active"</c:if>><a href="#frame2"><spring:message code="pratica.comunicazione.evento.scadenze"/></a></li>
                        </c:if>
                        <c:if test="${not empty scadenze_da_chiudere}">
                        <li <c:if test="${comunicazione.activeTab == '#frame3'}">class="active"</c:if>><a href="#frame3"><spring:message code="pratica.comunicazione.evento.scadenze"/></a></li>
                        </c:if>
                    <li <c:if test="${comunicazione.activeTab == '#frame8'}">class="active"</c:if>>
                        <a href="#frame8"><spring:message code="pratica.comunicazione.evento.altreazioni"/></a>
                    </li>
                </ul>
                <!-- Contenuto cartelle -->
                <div class="frames">
                    <c:if test="${processo_evento.flgMail== 'S'}">
                        <c:if test="${processo_evento.verso=='O'}">
                            <div class="frame active ordinariaDiv" style="display:none">
                                <label>
                                    <spring:message code="evento.posta.ordinaria.titolo"/> 
                                </label>
                                <div>
                                    <spring:message code="evento.posta.ordinaria.testo"/> 
                                    <table class="master" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th><spring:message code="evento.posta.ordinaria.testo"/> </th>
                                        </tr>
                                        <tr id="tr" style="display:none">
                                            <td class="ordinariaNominativo"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                        <div class="frame <c:if test="${comunicazione.activeTab == '#frame1'}">active</c:if>" id="frame1">
                                <div>
                                <tiles:insertAttribute name="comunicazione_mail" />                                
                            </div>
                        </div>
                    </c:if> 
                    <c:if test="${processo_evento.flgScadenzeCustom == 'S'}">
                        <div class="frame <c:if test="${comunicazione.activeTab == '#frame2'}">active</c:if>"  id="frame2">
                                <div>
                                    <table cellspacing="0" cellpadding="0" class="master">
                                        <tbody>
                                            <tr>
                                                <th>
                                                <spring:message code="pratica.comunicazione.evento.scadenza.descrizione"/>
                                            </th>
                                            <th style="width: 100px">
                                                <spring:message code="pratica.comunicazione.evento.scadenza.termini"/>
                                            </th>
                                        </tr>
                                        <c:set var="countScadenze" value="0" scope="page" />
                                        <c:forEach items="${processo_evento.processiEventiScadenzeList}" begin="0" var="eventoScadenza" varStatus="status">
                                            <tr>
                                                <td>
                                                    <%--<input type="hidden" name="scadenzeCustom[${countScadenze}].idEvento" value="${processo_evento.idEvento}" />--%>
                                                    <form:hidden path="scadenzeCustom[${countScadenze}].idAnaScadenza"/>
                                                    <form:input path="scadenzeCustom[${countScadenze}].descrizione" class="textInputScadenze"/>
                                                    <%--                                                    <input type="hidden" name="scadenzeCustom[${countScadenze}].idAnaScadenza" value="${eventoScadenza.scadenza.idAnaScadenze}" />
                                                                                                        <input type="text" name="scadenzeCustom[${countScadenze}].descrizione" class="textInputScadenze" value="${eventoScadenza.scadenza.desAnaScadenze}"/>--%>
                                                </td>
                                                <td>
                                                    <form:input path="scadenzeCustom[${countScadenze}].termini" class="textInputScadenze" />
                                                    <%--<input type="text" name="scadenzeCustom[${countScadenze}].termini" class="textInputScadenze" value="${eventoScadenza.terminiScadenza}"/>--%>
                                                </td>
                                            </tr>
                                            <c:set var="countScadenze" value="${countScadenze + 1}" scope="page"/>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty scadenze_da_chiudere}">
                        <div class="frame <c:if test="${comunicazione.activeTab == '#frame3'}">active</c:if>"  id="frame3">
                                <div>
                                <tiles:insertAttribute name="comunicazione_scadenze" />
                            </div>
                        </div>	
                    </c:if>

                    <c:if test="${processo_evento.verso=='I'}">
                        <div class="frame <c:if test="${comunicazione.activeTab == '#frame4'}">active</c:if>"  id="frame4">
                                <div>
                                <label for="destinatari_a" class="required">
                                <spring:message code="pratica.comunicazione.evento.mittenti"/>
                                </label>        
                                <tiles:insertAttribute name="comunicazione_mittenti" />
                            <div class="clear"></div>
                        </div>
                    </div>
                </c:if>

                <div class="frame <c:if test="${comunicazione.activeTab == '#frame5'}">active</c:if>"  id="frame5">
                        <div>

                        <tiles:insertAttribute name="comunicazione_file_upload" />
                    </div>
                </div>  
<%--                 <c:if test="${processo_evento.flgProtocollazione=='S'}"> --%>
                <c:if test="${processo_evento.flgProtocollazione=='Pippo'}">
                    <div class="frame <c:if test="${comunicazione.activeTab == '#frame6'}">active</c:if>"  id="frame6">

                            <div class="ctrlHolder">



                                <!-- COME ERA PRIMA--> 
                                <!--                                Descrizione <br/>                            -->
                                <!--                                <input type="file" name="allegatoOriginale.file" class=""/><br/>-->



                                <!--  INSERITO DA GAB MON-->
                                <!--****************************************************************************************************************************************************************************************************************************-->
                                <input style="display:none"  id="originalupload" type="file" name="file"  data-url="<%=path%>/ajax_upload.htm" onchange="disableSubmit();
                                        return false;"/> 
                            <label>Caricare o sostituire l'allegato originale rilasciando il file nella zona sottostante (Drop zone) o cliccando il pulsante "Aggiungi allegato" per cercarlo nel computer.</label>
                            <table  class="master" cellspacing="0" cellpadding="0">
                                <tr>
                                    <th>                                                    </th>
                                    <th>                       Descrizione                  </th>
                                    <th>                        Nome                        </th>
                                    <th>                        Formato                     </th>
                                </tr>
                                <tr id="uploaded-files-info"> 
                                    <td> <b>File originale:</b>              </td>
                                    <td><form:input path="allegatoOriginale.descrizione" class="fileObbligatorio" style="float:left;width:100%;margin-right:20px" /></td>


                                    <td class="loadedfile"> <c:if test="${!empty allegatoOriginale.pathFile}" >  <input style="display:none" type="text" name="allegatoOriginale.pathFile" value="${allegatoOriginale.pathFile}"  class="loadedfile"  /> <input style="display:none" type="text" name="allegatoOriginale.nomeFile" value="${allegatoOriginale.nomeFile}"  class="loadedfile"  /> ${allegatoOriginale.nomeFile}</c:if> </td>
                                    <td class="loadedfile"> <c:if test="${!empty allegatoOriginale.pathFile}">  <input style="display:none"  type="text" name="allegatoOriginale.tipoFile" value="${allegatoOriginale.tipoFile}"  class="loadedfile"  /> ${allegatoOriginale.tipoFile} </c:if>             </td>                   

                                    </tr>  
                                </table>

                                <div class="dropzone_container" id="dropzone">DROP ZONE</div>
                                <br/>
                                <br/>
                            </div>
                            <div class="aggiungiAllegato">
                                <a onclick="uploadOriginal();
                                        return false;" class="crea_nuovo_evento">
                                <spring:message code="pratica.comunicazione.evento.aggiungiallegato"/>
                            </a> 
                        </div>

                        <!--****************************************************************************************************************************************************************************************************************************-->


                    </div>
                </c:if>
                <div class="frame <c:if test="${comunicazione.activeTab == '#frame7'}">active</c:if>"  id="frame7">
                        <div class="ctrlHolder">
                        <c:choose>
                            <c:when test="${(!empty templates) && (processo_evento.flgRicevuta=='S')}">
                                <c:forEach items="${templates}" begin="0" var="allegato">
                                    <div class="allegatiGenerati">
                                        <a href="<%=path%>/download/generated.htm?id_pratica=${pratica.idPratica}&idEventoTemplate=${allegato.idEventoTemplate}" target="_blank" class="scarica" title="${allegato.descrizioneTemplate}" >
                                            ${allegato.descrizioneTemplate}
                                        </a>
                                    </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="allegatiGenerati allegatiMessage">
                                    <spring:message code="pratica.comunicazione.template.notemplate"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="frame <c:if test="${comunicazione.activeTab == '#frame8'}">active</c:if>"  id="frame8">
                        <div class="">
                        <c:if test="${processo_evento.flgPortale == 'S'}">
                            <div class="ctrlHolder form_checkbox_div">
                                <form:label path="visualizzaEventoPortale" style="font-size: 1em;"><spring:message code="pratica.comunicazione.evento.pubblica"/></form:label>
                                <form:checkbox path="visualizzaEventoPortale"/>
                            </div>
                        </c:if>
                        <div class="ctrlHolder dettaglio_liv_0" style="display:block;">
                            <h4 class="readOnlyLabel"><form:label path="contenuto" class="required"><spring:message code="pratica.comunicazione.evento.note"/></form:label></h4>
                            <form:textarea cols="25" rows="25" path="note" style="width:100%;"/>
                        </div>           
                    </div>
                </div>
            </div>
        </div>
        <div class="buttonHolder">
            <a href="<%=path%>/pratica/evento/index.htm?id_pratica=${pratica.idPratica}<c:if test="${not empty verso}">&verso=${verso}</c:if><c:if test="${not empty id_protocollo}">&id_protocollo=${id_protocollo}</c:if>" class="secondaryAction">&larr; <spring:message code="pratica.button.indietro"/></a>
            <form:hidden path="activeTab" id="comunicazione_active_tab"/>
            <form:hidden path="idEvento"/>
            <form:hidden path="idPratica"/>
            <form:hidden path="idPraticaProtocollo"/>
            <form:hidden path="initialized" value="true"/>
            <button tipoprotocollo="${tipoprotocollo}" value="<spring:message code="pratica.comunicazione.evento.procedi"/>" id="creaEvento" class="primaryAction" name="submitaction" onclick="triggersubmit();
                    return false;">
                <spring:message code="pratica.comunicazione.evento.procedi"/>
            </button>
        </div>
    </form:form>
</div>
<div class="clear"></div>
</div>



<!--   INSERITO DA GAB MON-->
<!--****************************************************************************************************************************************************************************************************************************-->
<!--            attiva il bottone di load di un file-->
<script>
    function uploadOriginal() {
        $("#originalupload").trigger('click');
    }
</script>
<script>
    function triggersubmit() {
    	debugger;
    	if($('.documenti_allegati_principale:checkbox:checked').length > 1){
    		alert("Inserire un solo allegato principale");
    	}else{
    		var div = $("<div>");
            var messaggio = "";
            var idprot = $("#protocollo input").val();
            var tipoprotocollo = $("#creaEvento").attr("tipoprotocollo");
            messaggio = "<spring:message code="evento.crea.conferma"/>";
            if (tipoprotocollo === "S") {
                messaggio += "<spring:message code="evento.crea.conferma.protocollo"/>";
                if (idprot === "") {
                    messaggio += " " + "<spring:message code="evento.crea.conferma.protocolloautomatico"/>";
                }
            }
            div.html(messaggio);
            $(div).dialog(
                    {
                        modal: true,
                        title: "Conferma creazione nuovo evento",
                        buttons: {
                            Ok: function() {
                                $(div).dialog('close');
                                $('button[name="submitaction"]').attr('disabled','disabled');
                                $("#creazioneEventoForm").submit();
                                return true;
                            },
                            Annulla: function() {
                                $(this).dialog('close');
                                return false;
                            }
                        }
                    });
    	}
        
    }
</script>
<!--****************************************************************************************************************************************************************************************************************************-->



<!--   INSERITO DA GAB MON-->
<!--****************************************************************************************************************************************************************************************************************************-->
<!--  SERVE CHE VENGA ESEGUITO ANCHE LO SCRIPT DI JQUERY MA e' GIA' INCLUSO ALTROVE NELLA PAGINA E VENGONO ERRORI SE SI INCLUDE ANCHE QUI
-->


<script src="/cross/javascript/jquery.iframe-transport.js"></script>
<script src="/cross/javascript/jquery.fileupload.js"></script>
<script src="/cross/javascript/myuploadfunction.js"></script>  
<!--****************************************************************************************************************************************************************************************************************************-->