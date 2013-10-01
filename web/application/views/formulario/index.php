	<section class="container vertical">
		<form method="POST">
			<fieldset>
				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="nome" title="Nome">Nome</label>
						<input type="text" class="form-control" name="nome" id="nome" placeholder="Nome">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="prontuario" title="Prontuário">Prontuário</label>
						<input type="text" class="form-control" name="prontuario" id="prontuario" placeholder="Prontuário">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="curso" title="Curso">Curso</label>
						<input type="text" class="form-control" name="curso" id="curso" placeholder="Curso">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="semestre" title="Semestre">Semestre</label>
						<input type="text" class="form-control" name="semestre" id="semestre" placeholder="Semestre">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="data_nascimento" title="Data de Nascimento">Data de Nascimento</label>
						<input type="text" class="form-control" name="data_nascimento" id="data_nascimento" placeholder="Data de Nascimento">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="rg" title="RG">RG</label>
						<input type="text" class="form-control" name="rg" id="rg" placeholder="RG">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="cpf" title="CPF">CPF</label>
						<input type="text" class="form-control" name="cpf" id="cpf" placeholder="CPF">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="email" title="Email">Email</label>
						<input type="text" class="form-control" name="email" id="email" placeholder="Email">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="idade" title="Idade">Idade</label>
						<input type="text" class="form-control" name="idade" id="idade" placeholder="Idade">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label for="naturalidade" title="Naturalidade">Naturalidade</label>
						<input type="text" class="form-control" name="naturalidade" id="naturalidade" placeholder="Naturalidade">
					</div>
				</article>

				<article class="row mbm">
					<div class="col-md-5 centered">
						<label>Estado civil</label>

						<label class="radio">
							<input type="radio" name="estado_civil" value="1" data-toggle="radio" checked>Solteiro
						</label>

						<label class="radio">
							<input type="radio" name="estado_civil" value="2" data-toggle="radio">Casado/mora com companheiro
						</label>

						<label class="radio">
							<input type="radio" name="estado_civil" value="3" data-toggle="radio">Separado/divorciado
						</label>

						<label class="radio">
							<input type="radio" name="estado_civil" value="4" data-toggle="radio">Viúvo
						</label>
					</div>
				</article>
			</fieldset>

			<article class="row mbm">
				<div class="col-md-5 centered text-right">
					<input type="reset" class="btn btn-default" value="Limpar" title="Limpar">
					<input type="submit" class="btn btn-success" value="Enviar" title="Enviar">
				</div>
			</article>
		</form>
	</section>
