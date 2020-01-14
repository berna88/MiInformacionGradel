<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="row alt">
	<article class="col-12" >
		<div class="logo" style="width: 100%; height: 90px;">
			
		</div>
		<div class="nombre">
		<div style="z-index:1;width: 172px;height: 88px;position: absolute;right: 0;top: 0;">
			<a target="_blank"  style="list-style: none;opacity: 1;" href=" https://performancemanager5.successfactors.eu/login?company=casacuervo#/login">
				<img width="168" alt="" src='<%=request.getContextPath()+"/img/icon_igrow.png"%>'>
			</a>
		</div>
			<section class="row">
				<article class="col-12 col-sm-12 col-md-12 col-lg-5 col-xs-5">
					<img  id="img-perfil" alt="" src='<%=usuario.getImagenPerfil() %>'>
				</article>
				<article class="col-12 col-sm-12 col-md-12 col-lg-7 col-xs-7">
					
					<hgroup id="nombres">
						<h4 style="padding-left: 1rem;" class="fw-g"><%= usuario.getApellidos() %></h4>
						<h2 style="padding-left: 1rem;" class="bolder l-h" ><%= usuario.getNombres() %></h2>
					</hgroup>
					
				</article>
			</section>
		</div>
	</article>
</section>