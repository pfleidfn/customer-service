package contracts.customer

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/customer/42'
	}
	response {
		status 404
	}

}
