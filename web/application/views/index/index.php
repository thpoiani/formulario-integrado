<section class="container vertical">
    <form method="POST" id="Formulario" action="/index/salvar">
        <fieldset>
            <article class="row mbm">
                <div class="col-md-5 centered">
                <h6>Validação</h6>
                </div>
            </article>

            <article class="row mbm">
                <div class="col-md-5 centered">
                    <label for="prontuario" title="Prontuário">Prontuário</label>
                    <input type="text" class="form-control" id="prontuario" name="prontuario" placeholder="Prontuário">
                </div>
            </article>

            <article class="row mbm">
                <div class="col-md-5 centered">
                    <label for="passwd" title="Senha">Senha</label>
                    <input type="text" class="form-control" id="passwd" name="passwd" placeholder="Senha">
                </div>
            </article>
        </fieldset>
    </form>
</section>

<section class="container vertical">
    <div class="row mbm">
        <div class="col-md-5 centered text-right">
            <button class="btn btn-success">Login</button>
        </div>
    </div>
</section>