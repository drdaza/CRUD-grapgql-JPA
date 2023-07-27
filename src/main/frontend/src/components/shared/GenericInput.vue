<script setup>
import { ref } from 'vue';

const props = defineProps({
    value: {
        type: String || Number,
        required: false,
        default: ''
    },
    type: {
        type: String,
        required: true,
        default: 'text'
    }
})

const valueOfInput = ref(null)

const emits = defineEmits(['emitValueInput'])

const emitValueInput = (event) => {
    const emitMapOptions = {
        'text': ()=>{
            parseValue(event.target.value)
            emits('emitValueInput', event.target.value)
        },
        'number': ()=>{
            if (Number.isNaN(parseFloat(event.data))) {
                parseValue(event.target.value)
                return
            }
            parseValue(event.target.value)
            debugger
            emits('emitValueInput', !Number.isNaN(parseFloat(event.target.value)) ? event.target.value : '')
        }
    }
    emitMapOptions[props.type]()
}

const parseValue = (value)=>{
    const parseValueOptions = {
        'text': ()=>{
            debugger
            valueOfInput.value = value
        },
        'number': ()=>{
            console.log(typeof value);
            if(!Number.isNaN(parseFloat(value))) { value = parseFloat(value)
            }
            console.log(typeof value);
            (typeof value === 'string') ? valueOfInput.value = '' : valueOfInput.value = value
        }
    }
    return parseValueOptions[props.type]() || null
}

</script>
<template>
    <div class="generic-input-wrapper">
        <label class="generic-input-label"><b>This is a normal Input</b></label>
        <input :value="valueOfInput" type="text" class="generic-input-style" @input="emitValueInput">
    </div>
</template>
<style lang="scss" scoped>
.generic-input-wrapper {
    display: flex;
    flex-direction: column;
    gap: 1vh;
    width: 250px;
    .generic-input-style {
        transition: 0.2s;
        height: 4vh;
        font-size: medium;
        border-top: none;
        border-left: none;
        border-right: none;
        border-bottom: solid blanchedalmond 1.5px;
    }
    .generic-input-style:focus{
        transition: 0.2s;
        border-bottom: solid green 1px;
        outline: none; 
    }

}
</style>