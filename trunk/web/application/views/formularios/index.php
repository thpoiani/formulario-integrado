<section class="container vertical">
    <article class="row mbm">
        <div class="align-center">
            <h6>Formulários Ativos</h6>
        </div>
    </article>
</section>

<section class="container vertical">
    <div class="row">
        <?php
            foreach ($this->formularios as $key => $formulario) { ?>
                <div class="col-md-3">
                    <a title="<?php echo $formulario->getTitulo(); ?>" href="/formulario/index/?id=<?php echo $formulario->getId(); ?>">
                        <div class="tooltip-inner tile <?php echo $this->color[$key]; ?>">
                            <span style="font-size: 14pt;"><?php echo $formulario->getTitulo(); ?></span>
                        </div>
                    </a>
                </div>
        <?php } ?>               
    </div>
</section>


