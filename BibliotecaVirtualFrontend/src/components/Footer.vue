<template>
    <div class="footer" style="background-color:#7752CB; color: white; font-size: 20px;">
        <p>{{creditos}}</p>
    </div>

</template>

<script>
    export default {
        data(){
            return{
                creditos: "Todos los derechos reservados 2022."
            }
        }
    }

</script>

<style>
.footer {
position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  padding-left: 5px
}
</style>