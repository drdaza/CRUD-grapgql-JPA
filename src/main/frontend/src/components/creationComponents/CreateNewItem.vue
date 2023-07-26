<script setup>
import { RouterView } from 'vue-router'
const props = defineProps({
    typeOfElement: {
        type: String,
        required: true,
        default: null
    }
})
const creationOptions = {
    'author': ()=>{console.log('try create a new author')},
    'book': ()=>{console.log('tye create a new book');}
}
// incluir la posibilidad de que si no se escoge un author cuando creemos un libro se cree con un author de nombre desconocido
// esta idea evolucionó a ser mi pequeña libreta para anotar libros pendientes que me vayan interesando a y poder anotarlos/organizarlos/eliminarlos
// para poder practicar, cambiarlos de estado a leidos o cosas asi
</script>
<template> 
    <div class="create-new-item-container">
        <RouterView/>
    </div>
</template>
