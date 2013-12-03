
<?php if (isset($this->formulario)) {  ?>

    <section class="container vertical no-padding">
        <article class="row mbm">
            <div class="align-center">
                <h6><?php echo utf8_encode($this->formulario->getTitulo()); ?></h6>
            </div>
        </article>
    </section>

    <form method="POST" action="/formulario/salvar">
        <input type="hidden" id="formulario" name="formulario" value="<?php echo $this->formulario->getId(); ?>">

        <?php foreach ($this->formulario->getCategorias() as $categoria) { ?>

        <section class="container vertical">
            <fieldset>
                <?php
                foreach ($categoria->getCampos() as $campo) {
                    switch ($campo->getTipo()->getDescricao()) {
                        case 'Check':
                    ?>

                <article class="row mbm">
                    <div class="col-md-5 centered">
                        <label><?php echo utf8_encode($campo->getTitulo()); ?></label>
                        <?php foreach($campo->getGrupos() as $grupo) { ?>

                        <label class="checkbox cursor-pointer" title="<?php echo utf8_encode($grupo->getTitulo()) ?>">
                            <input type="checkbox" name="<?php echo $campo->getId() ?>" 
                            value="<?php echo $grupo->getId() ?>" data-toggle="checkbox"><?php echo utf8_encode($grupo->getTitulo()) ?>

                        </label>
                        <?php } ?>

                    </div>
                </article>

                    <?php
                        break;

                        case 'Data':
                    ?>

                <article class="row mbm">
                    <div class="col-md-5 centered">
                        <label for="<?php echo $campo->getId(); ?>" title="<?php echo utf8_encode($campo->getTitulo()); ?>"><?php echo utf8_encode($campo->getTitulo()); ?></label>
                        <input type="date" data-date-format="dd/mm/yyyy" name="<?php echo $campo->getId(); ?>" id="<?php echo $campo->getId(); ?>">
                    </div>
                </article>

                    <?php
                        break;

                        case 'Radio':
                    ?>

                <article class="row mbm">
                    <div class="col-md-5 centered">
                        <label><?php echo utf8_encode($campo->getTitulo()); ?></label>
                        <?php foreach($campo->getGrupos() as $key => $grupo) { ?>

                        <label class="radio cursor-pointer" title="<?php echo utf8_encode($grupo->getTitulo()) ?>">
                            <input type="radio" name="<?php echo $campo->getId() ?>" value="<?php echo $grupo->getId() ?>" data-toggle="radio"<?php echo $key == 0 ? " checked" : "" ?>><?php echo utf8_encode($grupo->getTitulo()) ?>

                        </label>
                        <?php } ?>

                    </div>
                </article>

                    <?php
                        break;

                        default:
                    ?>

                <article class="row mbm">
                    <div class="col-md-5 centered">
                        <label for="<?php echo $campo->getId(); ?>" title="<?php echo utf8_encode($campo->getTitulo()); ?>"><?php echo utf8_encode($campo->getTitulo()); ?></label>
                        <input type="text" class="form-control" name="<?php echo $campo->getId(); ?>" id="<?php echo $campo->getId(); ?>" placeholder="<?php echo utf8_encode($campo->getTitulo()); ?>"<?php echo ($campo->getMaxlength() > 0 ? ' maxlength="' . $campo->getMaxlength() . '"' : ''); ?><?php echo (strlen($campo->getRegex()) > 0 ? ' pattern="' . utf8_encode($campo->getRegex()) . '"' : ''); ?>>
                    </div>
                </article>

                    <?php
                        break;
                    }
                } ?>

            </fieldset>
        </section>
        <?php } ?>

        <section class="container vertical">
			<article class="row mbm">
				<div class="col-md-5 centered text-right">
					<input type="reset" class="btn btn-default" value="Limpar" title="Limpar">
					<input type="submit" class="btn btn-success" value="Enviar" title="Enviar">
				</div>
			</article>
        </section>
	</form>

<?php } ?>