<script setup>
import { ref, reactive, computed,toRef } from 'vue';
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
    },
    label: {
        type: String,
        required: false,
        default: 'label'
    },
    inputIdentifier: {
        type: String,
        required: true,
        default: null
    }
})
// emits
const emits = defineEmits(['emitValueInput'])

// data
const valueOfInput = ref(null)
const numberValue = reactive({
    symbol: '',
    intValue: '',
    decimalSymbol: '',
    decimalValue: '',
    numericValue: ''
})
const NEGATIVE_SYMBOL = '-'
const POSITIVE_SYMBOL = '+'
const EMPTY_SYMBOL = ''
const DECIMAL_SYMBOL = '.'


// methods
const inputHandler = (event) => {
    const validNumberExpresions = [/^[-+]?[0-9]*[,.]?[0-9]?[0-9]+$/, /^[-+]?[0-9]$/, /^[-+]?[0-9]*[,.]$/]
    const lastValueInput = event.data
    let inputValue = event.target.value

    const emitMapOptions = {
        'text': ()=>{
            valueOfInput.value = inputValue
            parseValue(inputValue)
        },
        'number': ()=>{
            
            const inputValueHasMoreThanOneDecimalSymbol = inputValue.split('').filter(symbol =>  symbol === DECIMAL_SYMBOL).length > 1

            if (lastValueInput === NEGATIVE_SYMBOL) {
                numberValue.symbol = NEGATIVE_SYMBOL
            }

            if (lastValueInput === POSITIVE_SYMBOL || !inputValue.includes(NEGATIVE_SYMBOL)){
                numberValue.symbol = POSITIVE_SYMBOL
            }

            if ((lastValueInput === DECIMAL_SYMBOL) && (valueOfInput.value === null || valueOfInput.value === NEGATIVE_SYMBOL || valueOfInput.value === EMPTY_SYMBOL) ) {
                inputValue = numberValue.symbol === NEGATIVE_SYMBOL ? `${numberValue.symbol}${lastValueInput}` : lastValueInput
                return
            }

            
            if (inputValueHasMoreThanOneDecimalSymbol && lastValueInput === DECIMAL_SYMBOL) {
                event.target.value = valueOfInput.value
                inputValue = valueOfInput.value
                return
            }

            inputValue = inputValue.replace(POSITIVE_SYMBOL, EMPTY_SYMBOL) 
            inputValue = inputValue.replace(NEGATIVE_SYMBOL, EMPTY_SYMBOL)
            
            if (inputValue !== EMPTY_SYMBOL && !validNumberExpresions.find(regex => regex.test(inputValue))) {
                event.target.value = valueOfInput.value
                return
            }

            numberValue.numericValue = inputValue
            parseValue(inputValue)
        }
    }
    emitMapOptions[props.type]()
}

const parseValue = (value = null)=>{
    const parseValueOptions = {
        'text': ()=>{
            
            emits('emitValueInput', {identifier: props.inputIdentifier , value: valueOfInput.value})
        },
        'number': ()=>{
            if (numberValue.numericValue === EMPTY_SYMBOL){
                valueOfInput.value = numberValue.symbol === NEGATIVE_SYMBOL ? numberValue.symbol : EMPTY_SYMBOL
                return
            }

            valueOfInput.value = numberValue.symbol === NEGATIVE_SYMBOL ? parseFloat(`${numberValue.symbol}${numberValue.numericValue}`) : parseFloat(value)

            emits('emitValueInput', {identifier: props.inputIdentifier ,value: valueOfInput.value})
        }
    }
    return parseValueOptions[props.type]() || null
}

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
        <label class="generic-input-label"><b>{{ label }}</b></label>
        <input :value="valueOfInput" type="text" class="generic-input-style" @input="inputHandler">
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