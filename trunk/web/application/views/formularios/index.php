
<?php if (count($this->formularios) > 0) { ?>

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
            foreach ($this->formularios as $key => $formulario) {
                $key = $key % count($this->color); ?>
                <div class="col-md-3">
                    <a title="<?php echo utf8_encode($formulario->getTitulo()); ?>" href="/formulario/index/?id=<?php echo $formulario->getId(); ?>">
                        <div class="tooltip-inner tile <?php echo $this->color[$key]; ?>">
                            <span class="font"><?php echo utf8_encode($formulario->getTitulo()); ?></span>
                        </div>
                    </a>
                </div>
        <?php } ?>
    </div>
</section>
<?php } else { ?>

<section class="container vertical">
    <article class="row mbm">
        <div class="align-center">
            <h6>Nenhum formulário ativos</h6>
        </div>
    </article>
</section>

<?php } ?>
