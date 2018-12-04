import spock.lang.*

class Point implements Comparable {
	def x
	def y

	@Override int compareTo(p){
		if (p.x < x) return -1
		if (p.x > x) return 1
		if (p.y < y) return -1
		if (p.y > y) return 1
		return 0
	}
}

class Triangle {
	def points = []

	def add_point(point) {
		points << point
	}
	def get_count() {
		points.size()
	}
	def get_area() {
		return Math.abs(((points[1].x - points[0].x) * (points[2].y - points[0].y) - 
						(points[2].x - points[0].x) * (points[1].y - points[0].y)) / 2)
	}
}

@Stepwise
class Stepwise_Triangle_Spec extends Specification {

	@Shared tr = new Triangle()
	def setup() {
		tr.add_point(new Point(x:0, y:0))
		tr.add_point(new Point(x:1, y:0))
		tr.add_point(new Point(x:1, y:1))
	}

	def "step 1 - triangle has 3 points"() {
		expect: tr.get_count() == 3
	}

	def "step 2 - triangle has distinct points"() {
		expect: tr.points[0] <=> tr.points[1]
				tr.points[1] <=> tr.points[2]
				tr.points[0] <=> tr.points[2]
	}

	def "step 3 - check area"() {
		expect: Math.abs(tr.get_area() - 0.5) < 0.0001
	}
}
