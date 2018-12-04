import spock.lang.*

@Stepwise
class Stepwise_Spec extends Specification {

	@Shared index = 0

	def "step 1"() {
		index = index + 1
		expect: index == 1
	}

	def "step 2"() {
		index = index + 1
		expect: index == 2
	}

	def "step 3"() {
		index = index + 1
		expect: index == 3
	}
}
