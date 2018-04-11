## TDD
1. 编写Course类的测试及对应的实现。(10分钟) 实际：5分钟
	* 测试课程序号
	* 测试课程数
2. 编写Student类的测试及对应的实现。(20分钟) 实际：70分钟
	* 测试构造器和toString()，确保数据正常使用
	* 测试getGrade()
	* 测试getAvgGrade()
	* 测试getTotalGrade()
3. 编写GradeList类的测试及对应的实现。(30分钟) 实际：87分钟
	* 测试totalAverage()
	* 测试totalMedian()
	* 测试GradeList的构造器和display()
4. 编写MenuItem类的测试及对应的实现。(10分钟) 实际：4分钟
	* 测试构造器和getName
	* 测试performAction
5. 编写Menu类的测试及对应的实现。(20分钟)
	* 测试addMenuItem(), display() // 使用Mock模拟MenuItem
	* 测试performAction() // 使用Mock模拟MenuItem
6. 编写MIAddStudent类的测试及对应的实现。(20分钟)
	* 测试getName()
	* 测试performAction() // 使用Mock模拟Student和GradeList
7. 编写MIGenerateGradeList类的测试及对应的实现。(15分钟)
	* 测试getName()
	* 测试performAction() // 使用Mock模拟GradeList
8. 编写Library类的测试及对应的实现。(30分钟)

## 原因分析
1. 时间保守估算。
2. 设计存在问题，关于需求的细节没有考虑到。设计不完善，临时引入了许多子任务。不够熟练，不知道Junit处理double相等。
3. 没有很好地估计写测试需要的时间。