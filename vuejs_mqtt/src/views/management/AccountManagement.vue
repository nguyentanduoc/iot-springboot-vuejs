<template>
	<v-container :id="$options.name" grid-list-md text-xs-center>
		<v-layout row wrap>
			<v-flex xs4>
				<from-create-account/>
			</v-flex>
			<v-flex xs8>
				<list-account/>
			</v-flex>
		</v-layout>
	</v-container>
</template>

<script>
  import ListAccount from '../../components/account/ListAccount'
  import FormCreateAccount from '../../components/account/FormCreateAccount'

  export default {
    name: "Account",
    components: {
      "list-account": ListAccount,
      "from-create-account": FormCreateAccount
    },
    data() {
      return {}
    }
  }
</script>

<style scoped>

</style>