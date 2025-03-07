<template>

    <v-card outlined>
        <v-card-title>
            LostInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="DeviceId" v-model="item.deviceId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MemberId" v-model="item.memberId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Contact" v-model="item.contact" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Information" v-model="item.information" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'LostInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/lostInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

