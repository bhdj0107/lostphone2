<template>

    <v-card outlined>
        <v-card-title>
            MemberInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Contact" v-model="item.contact" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MemberInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/memberInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

