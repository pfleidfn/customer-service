package contracts.customer

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'GET'
		url '/customer/1'
	}
	response {
		status 200
		body([
				lastName : 'Pfleiderer'
		])
		headers {
			contentType(applicationJsonUtf8())
		}
	}

}
