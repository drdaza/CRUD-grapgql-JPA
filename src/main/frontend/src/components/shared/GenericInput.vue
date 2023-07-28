<script setup>
import { ref, reactive, computed } from 'vue';
// props
const props = defineProps({
    value: {
        type: [String, Number],
        required: false,
        default: ''
    },
    type: {
        type: String,
        required: true,
        default: 'text'
    }
})
// emits
const emits = defineEmits(['emitValueInput'])

// data
const valueOfInput = ref(null)
const numberValue = reactive({
    symbol: '',
    intValue: '',
    decimalSymbol: '.',
    decimalValue: ''
})

// methods
const inputHandler = (event) => {
    const validExpressions = [/^-?\d+$/, /^-?\d+(\.\d+)?(,\d+)?$/]
    const lastValueInput = event.data
    let eventHandlerValue = event.target.value

    const emitMapOptions = {
        'text': ()=>{
            valueOfInput.value = parseValue(event.target.value)
        },
        'number': ()=>{
            console.log(validExpressions.map(exp => exp.test(event.data)));
            if (Number.isNaN(parseFloat(event.data))) {
                event.target.value = valueOfInput.value
                return
            }
            // parseValue(event.target.value)
            valueOfInput.value = parseValue(event.target.value)
        }
    }
    emitMapOptions[props.type]()
}

// const parseValue = (value)=>{
//     const parseValueOptions = {
//         'text': ()=>{
//             return value
//         },
//         'number': ()=>{
//             if (Number.isNaN(parseFloat(value))) return ''
//             return parseFloat(value)
//         }
//     }
//     return parseValueOptions[props.type]() || null
// }

// computed

const valueConstructor = computed(()=>{
    const parseValueOptions = {
        'text': ()=>{
            return valueOfInput
        },
        'number': ()=>{
            return parseFloat(`${numberValue.symbol}${numberValue.intValue}${numberValue.decimalSymbol}${numberValue.decimalValue}`)
        }
    }
    return parseValueOptions[props.type]() || null
})

</script>
<template>
    <div class="generic-input-wrapper">
        <label class="generic-input-label"><b>This is a normal Input</b></label>
        <input :value="valueOfInput" type="text" class="generic-input-style" @input="inputHandler">
    </div>
    <h1>{{ valueOfInput }}</h1>
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