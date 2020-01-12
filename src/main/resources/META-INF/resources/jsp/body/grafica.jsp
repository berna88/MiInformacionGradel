<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<div class="row">
				<div class="offset-1 col-10 offset-sm-1 col-sm-10 offset-md-1 col-md-10 col-lg-12 col-xl-12">
					<div class="fondo-grafica">
						<hgroup style="text-align: right;">
							<h1 id="remuneracion_total" class="cantidad-total"></h1>
							<h5 class="subtitulo-cantidad">Compensación total anual</h5>
						</hgroup>
						<div class="grafica-remuneracion top3" >					
							<canvas id="chart-area" style="display: block;height: auto;width: 100%;margin: auto;" height="55%" width="100%" class="chartjs-render-monitor"></canvas>
						</div>
						<div class="top3 ">
							<div>
								<div class="cuadrado magenta"></div><p id="comp_garant" style="font-size: 1em;" class="texto-grafica">Compensación Garantizada ( )</p>
							</div>
							<div>
								<div class="cuadrado yellow"></div><p id="comp_variable" style="font-size: 1em;" class="texto-grafica">Compensación Variable ( )</p>
							</div>
							<div>
								<div class="cuadrado cyan"></div><p id="mis_beneficios" style="font-size: 1em;" class="texto-grafica">Mis Beneficios ( )</p>
							</div>
						</div>
					</div>
				</div><!-- Fin de sección de grafica -->
			</div>