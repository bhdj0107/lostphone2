<template>
    <v-card outlined>
        <v-card-title>
            ChangeDeviceLocation
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="Location" v-model="value.location" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="changeDeviceLocation"
            >
                ChangeDeviceLocation
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
        name: 'ChangeDeviceLocationCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.location = '';
        },
        watch: {
        },
        methods: {
            changeDeviceLocation() {
                this.$emit('changeDeviceLocation', this.value);
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

