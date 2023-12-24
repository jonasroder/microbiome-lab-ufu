<script setup>
import CardFormulario from "@/components/CardFormulario.vue";
import TextInput from '@/components/TextInput.vue';
import SelectInput from '@/components/SelectInput.vue';
import AvatarImageInput from '@/components/AvatarImageInput.vue';
import {setNotification} from "@/plugins/notificationService";
import {onMounted, reactive, ref} from "vue";
import {serviceSave, serviceLoad, getEnderecoByCep} from "@/service/pessoa";
import {getIdFromUrl} from "@/service/common/utils"
import {loading} from "@/plugins/loadingService.js";


const id = ref(getIdFromUrl());


onMounted(async () => {
    loading.show()

    if (id.value > 0) {
        const data = await serviceLoad(id.value);
        console.log(data)
        Object.assign(endereco, data.endereco[0]);
        Object.assign(pessoa, data);
    }

    loading.hide()
});


const pessoa = reactive({
    id_pessoa: "",
    foto_perfil: "",
    nome: "",
    sobrenome: "",
    data_nascimento: "",
    telefone: "",
    email: "",
    id_estado_civil: "",
    id_profissao: "",
    cpf: "",
    id_etnia: "",
    id_escolaridade: "",
    id_religiao: "",
    id_sexo: "",
    id_tipo_pessoa: "",
    endereco : []
});

    
const endereco = reactive({
        logradouro: "",
        numero: "",
        complemento: "",
        bairro: "",
        cidade: "",
        id_uf: "",
        cep: "",
        referencia: ""
    })


const handleSave = async () => {
    loading.show()

    if(endereco) {
        pessoa.endereco[0] = endereco;
    }

    console.log(pessoa)
    if (id.value > 0) {
        const res = await serviceSave(pessoa, 'update');
        console.log(res)

    } else {
        const res = await serviceSave(pessoa, 'insert');
        id.value = res.id;
        if(id.value > 0) {
            pessoa.id_pessoa = res.id;
            const newUrl = `${window.location.protocol}//${window.location.host}${window.location.pathname}?id=${res.id}`;
            window.history.pushState({path: newUrl}, '', newUrl);
        }
    }


    loading.hide()

};


const handleBack = () => {
    // Implemente a lógica para voltar
    console.log('Retornando da tela de cadastro de usuário.');
};


const handleAppendIconClick = async () => {
    let respEndereco = {};
    if (endereco.cep.length >= 8) {
        respEndereco = await getEnderecoByCep(endereco.cep);
    } else {
        setNotification("O CEP é invalido", "error");
    }

    endereco.cep = respEndereco.cep;
    endereco.logradouro = respEndereco.logradouro;
    endereco.bairro = respEndereco.bairro;
    endereco.cidade = respEndereco.localidade;
    endereco.id_uf = respEndereco.uf;

};


</script>

<template>
    <card-formulario title="Cadastro de Pessoa"
                     subtitle="Centralizando Informações para Cuidado Integral"
                     @handleSave="handleSave"
                     @handleBack="handleBack">

        <v-row>
            <v-col cols="12"
                   sm="4"
                   md="3"
                   justify="center"
                   align="center">

                <AvatarImageInput v-model="pessoa.foto_perfil"/>
            </v-col>

            <v-col cols="12"
                   sm="8"
                   md="9">


                <v-row class="justify-end">

                    <text-input
                        v-model="pessoa.nome"
                        label="Nome"
                        type="text"
                        cols="12"
                        md="6"
                        lg="6"
                        xl="6"
                    />


                    <text-input
                        v-model="pessoa.sobrenome"
                        label="Sobrenome"
                        type="text"
                        cols="12"
                        md="6"
                        lg="6"
                        xl="6"
                    />


                    <SelectInput
                        label="Sexo"
                        placeholder="Digite ou selecione o Sexo"
                        idColumn="id_sexo"
                        descColumn="descricao"
                        tableName="sexo"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_sexo"
                        cols="12"
                        md="4"
                    />


                    <text-input
                        v-model="pessoa.data_nascimento"
                        label="Data de Nascimento"
                        type="date"
                        cols="12"
                        md="4"
                    />


                    <text-input
                        v-model="pessoa.cpf"
                        label="CPF"
                        type="text"
                        cols="12"
                        md="4"
                    />


                    <text-input
                        v-model="pessoa.telefone"
                        label="telefone"
                        type="phone"
                        :rules="['required']"
                        cols="12"
                        md="4"
                    />


                    <text-input
                        v-model="pessoa.email"
                        label="Email"
                        type="email"
                        :rules="['email', 'required']"
                        cols="12"
                        md="6"
                        lg="6"
                        xl="6"
                    />


                    <SelectInput
                        label="Etnia"
                        placeholder="Digite ou selecione uma Etnia"
                        idColumn="id_etnia"
                        descColumn="descricao"
                        tableName="etnia"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_etnia"
                        cols="12"
                        md="4"
                    />


                    <SelectInput
                        label="Escolaridade"
                        placeholder="Digite ou selecione uma Escolaridade"
                        idColumn="id_escolaridade"
                        descColumn="descricao"
                        tableName="escolaridade"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_escolaridade"
                        cols="12"
                        md="4"
                    />


                    <SelectInput
                        label="Religião"
                        placeholder="Digite ou selecione uma religião"
                        idColumn="id_religiao"
                        descColumn="descricao"
                        tableName="religiao"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_religiao"
                        cols="12"
                        md="4"
                    />


                    <SelectInput
                        label="Profissão"
                        placeholder="Digite ou selecione uma Profissão"
                        idColumn="id_profissao"
                        descColumn="descricao"
                        tableName="profissao"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_profissao"
                        cols="12"
                        md="4"
                    />


                    <SelectInput
                        label="Estado Civil"
                        placeholder="Digite ou selecione o Estado Civil"
                        idColumn="id_estado_civil"
                        descColumn="descricao"
                        tableName="estado_civil"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_estado_civil"
                        cols="12"
                        md="4"
                    />


                    <SelectInput
                        label="Tipo de Pessoa"
                        placeholder="Digite ou selecione o Tipo"
                        idColumn="id_tipo_pessoa"
                        descColumn="descricao"
                        tableName="tipo_pessoa"
                        :is_active="true"
                        :multiple="false"
                        v-model="pessoa.id_tipo_pessoa"
                        cols="12"
                        md="4"
                    />

                </v-row>
            </v-col>

            <v-col cols="12">

                <v-row align="center">
                    <v-col cols="auto">
                        <i class="fa fa-home fa-lg"
                           aria-hidden="true"></i>
                    </v-col>
                    <v-col>
                        <span class="text-h6">Endereço</span>
                    </v-col>
                </v-row>

                <v-divider class="border-opacity-100"
                           color="primary"/>

            </v-col>

            <v-col cols="12">
                <v-row>

                    <text-input
                        v-model="endereco.cep"
                        label="CEP"
                        type="text"
                        appendInnerIcon="fa-solid fa-search"
                        :rules="['required', 'cep']"
                        cols="12"
                        md="4"
                        @click:append-inner-icon="handleAppendIconClick"
                    />

                    <text-input
                        v-model="endereco.logradouro"
                        label="Rua"
                        type="text"
                        cols="12"
                        md="4"
                    />

                    <text-input
                        v-model="endereco.numero"
                        label="Número"
                        type="number"
                        cols="12"
                        md="4"
                    />

                    <text-input
                        v-model="endereco.complemento"
                        label="Complemento"
                        type="text"
                        cols="12"
                        md="4"
                    />

                    <text-input
                        v-model="endereco.bairro"
                        label="Bairro"
                        type="text"
                        cols="12"
                        md="4"
                    />

                    <text-input
                        v-model="endereco.cidade"
                        label="Bairro"
                        type="text"
                        cols="12"
                        md="4"
                    />

                    <SelectInput
                        label="UF"
                        placeholder="Digite ou selecione a UF"
                        v-model="endereco.id_uf"
                        idColumn="id_uf"
                        descColumn="sigla"
                        tableName="uf"
                        :is_active="true"
                        :multiple="false"
                        cols="12"
                        md="4"
                    />

                    <text-input
                        v-model="endereco.referencia"
                        label="Referência"
                        type="text"
                        cols="12"
                        md="4"
                    />


                </v-row>
            </v-col>


        </v-row>
    </card-formulario>
</template>
