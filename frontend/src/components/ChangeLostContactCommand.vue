<template>
    <v-card outlined>
        <v-card-title>
            ChangeLostContact
        </v-card-title>

        <v-card-text>
            <String label="Contact" v-model="value.contact" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="changeLostContact"
            >
                ChangeLostContact
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
        name: 'ChangeLostContactCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.contact = '';
        },
        watch: {
        },
        methods: {
            changeLostContact() {
                this.$emit('changeLostContact', this.value);
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

