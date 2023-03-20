<template>

    <v-card outlined>
        <v-card-title>
            DashBoard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FileId" v-model="item.fileId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FileSize" v-model="item.fileSize" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="UploadUser" v-model="item.uploadUser" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IsUploaded" v-model="item.isUploaded" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="IsIndexed" v-model="item.isIndexed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VideoUrl" v-model="item.videoUrl" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashBoardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashBoards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

