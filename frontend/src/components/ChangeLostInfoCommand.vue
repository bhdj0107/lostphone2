<template>
    <v-card outlined>
        <v-card-title>
            ChangeLostInfo
        </v-card-title>

        <v-card-text>
            <String label="Information" v-model="value.information" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="changeLostInfo"
            >
                ChangeLostInfo
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ChangeLostInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.information = '';
        },
        watch: {
        },
        methods: {
            changeLostInfo() {
                this.$emit('changeLostInfo', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

