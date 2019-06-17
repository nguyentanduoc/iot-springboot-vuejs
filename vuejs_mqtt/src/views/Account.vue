<template>
	<v-container grid-list-md text-xs-center>
		<v-layout id="account-view" row wrap>
			<v-flex xs6>
				<ListAccount/>
			</v-flex>
			<v-flex xs6>
				<FormCreateAccount/>
			</v-flex>
		</v-layout>
	</v-container>
</template>

<script>
  import ListAccount from '../components/account/ListAccount'
  import FormCreateAccount from '../components/account/FormCreateAccount'

  export default {
    name: "Account",
    components: {
      ListAccount,
      FormCreateAccount
    },
    data() {
      return {}
    }
  }
</script>

<style scoped>

</style>