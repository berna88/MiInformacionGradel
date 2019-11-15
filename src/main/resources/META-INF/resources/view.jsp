<%@page import="com.consistent.cuervo.remuneracion.builder.model.Remuneracion"%>
<%@page import="com.consistent.cuervo.miinformacion.portlet.models.Trabajador"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/banner.css"%>'>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/logo.css"%>'>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/perfil.css"%>'>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/2.8.0/Chart.min.css"%>'>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/grafica.css"%>'>
<link rel="stylesheet" type="text/css" href='<%=request.getContextPath()+"/css/general.css"%>'>

<script src='<%=request.getContextPath()+"/js/2.8.0/Chart.min.js"%>'></script>
<%
Trabajador usuario = (Trabajador) request.getAttribute("trabajador");
Remuneracion remuneracion = (Remuneracion) request.getAttribute("grafica");
%>
<%@ include file="jsp/header/banner.jsp" %>
<body id="miInformacion" class="container">
	<section class="row">
		<article class="offset-1 col-10 offset-sm-1 col-sm-10 offset-md-1 col-md-10 offset-lg-1 col-lg-6 offset-xl-1 col-xl-6">
			<%@ include file="jsp/body/informationUser.jsp" %>
			<hr class="hr-remuneracion">
			<%@ include file="jsp/body/dataUser.jsp" %>
		</article>
		<article class="col-12 col-sm-12 col-md-12 col-lg-4 col-xl-4">
			<%@ include file="jsp/body/grafica.jsp" %>
		</article>
	</section>
</body>
<%-- 
<script src='<%=request.getContextPath()+"/js/grafica.js"%>'></script>
--%>
 <script>
 $(function() {
var formatNumber = {		
		separador: ",", // separador para los miles
		sepDecimal: '.', // separador para los decimales
		formatear:function (num,dec){
			num = Math.round(num);
			num +='';
			var splitStr = num.split('.');
			var splitLeft = splitStr[0];
			var splitRight = splitStr.length > 1 ? this.sepDecimal + splitStr[1] : '';
			var regx = /(\d+)(\d{3})/;
			while (regx.test(splitLeft)) {
				splitLeft = splitLeft.replace(regx, '$1' + this.separador + '$2');
			}
			if(dec)
				return this.simbol + ' ' + splitLeft +splitRight+".00";
			else
				return this.simbol + ' ' + splitLeft +splitRight;
		},
		new:function(num, simbol, dec){
			this.simbol = simbol ||'';
			return this.formatear(num,dec);
		}
	}
<%if(remuneracion != null){%>
document.getElementById("remuneracion_total").innerHTML = formatNumber.new(<%= remuneracion.getRemuneracion_total() %>,'$ ',true);

var _remuneracion_total = <%= remuneracion.getRemuneracion_total() %>;
var _compensacion_garantizada = <%= remuneracion.getCompensacion_anual() %>;
var _compensacion_variable = <%= remuneracion.getCompensacion_variable_anual() %>;
var _mis_beneficios = <%= remuneracion.getBeneficia_anual() %>;

var _porcentaje_garantizada = Math.round((_compensacion_garantizada/_remuneracion_total)*100);
var _porcentaje_variable = Math.round((_compensacion_variable/_remuneracion_total)*100);
var _porcentaje_beneficios = Math.round((_mis_beneficios/_remuneracion_total)*100);


<%}%>

document.getElementById("comp_garant").innerHTML = 'Compensación Garantizada ( '+ _porcentaje_garantizada +'% )';
document.getElementById("comp_variable").innerHTML = 'Compensación Variable ( '+ _porcentaje_variable +'% )';
document.getElementById("mis_beneficios").innerHTML = 'Mis Beneficios ( '+ _porcentaje_beneficios +'% )';



window.chartColors = {
      yellow: 'rgb(255, 204, 106)',
      magenta: 'rgb(255, 58, 103)',
      cyan: 'rgb(40, 164, 229)'
    };

var config = {
type: 'pie',
data: {
	datasets: [{
		data: [
			_porcentaje_garantizada,
			_porcentaje_variable,
			_porcentaje_beneficios,
		],
		backgroundColor: [
			window.chartColors.magenta,
			window.chartColors.yellow,
			window.chartColors.cyan
		],
		label: 'Remuneracion'
	}],
	labels: [
		'Garantizada',
		'Variable',
		'Beneficios'
	]
},
options: {
	responsive: true,
	legend: {
		display:false,
		position: 'bottom',
        labels: {
            boxWidth: 20,
            padding: 20
        }
    }
},
tooltips: {
    callbacks: {
    	label: function(tooltipItem, data) {
    		var dataset = data.datasets[tooltipItem.datasetIndex];
    		var total = dataset.data.reduce(function(previousValue, currentValue, currentIndex, array) {
    			return previousValue + currentValue;
    		});
    		
    		var currentValue = dataset.data[tooltipItem.index];
    		var percentage = Math.floor(((currentValue/total) * 100)+0.5);
    		return " "+percentage + " %";
    										}
			}
		}
};

var ctx = document.getElementById('chart-area').getContext('2d');
window.myPie = new Chart(ctx, config);

 });

</script>