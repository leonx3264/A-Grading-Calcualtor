file = open("values.txt", "r")

param = file.readlines()

#attend , assign, quiz, test, final

#choice
#percent
#grade
#total

usr_name = param[0]

attendChoice = param[1]
attendPercent = param[2]
attendGrade = param[3]
attendTotal = eval(param[4])

assignChoice = param[5]
assignPercent = param[6]
assignGrade = param[7]
assignTotal = eval(param[8])

quizChoice = param[9]
quizPercent = param[10]
quizGrade = param[11]
quizTotal = eval(param[12])

testChoice = param[13]
testPercent = param[14]
testGrade = param[15]
testTotal = eval(param[16])

finalChoice = param[17]
finalPercent = param[18]
finalGrade = param[19]
finalTotal = eval(param[20])


#insert calc with values above




#1
attendance = attendChoice
if attendance == 0:
    percentage1 = attendPercent
    earnedPercentage = attendGrade
    attendancePercentage = attendTotal
else:
    percentage1 = attendPercent
    earnedPercentage = attendGrade
    attendancePercentage = attendTotal

#2   
assignment = assignChoice
if assignment == 0:
    percentage2 = assignPercent
    earnedPercentage = assignGrade
    assignmentPercentage = assignTotal
    
else:
    percentage2 = assignPercent
    earnedPercentage = assignGrade
    assignmentPercentage = assignTotal

#4 
quizzes = quizChoice
if quizzes == 0:
    percentage3 = quizPercent
    earnedPercentage = quizGrade
    quizzesPercentage = quizTotal
    
else:
    percentage3 = quizPercent
    earnedPercentage = quizGrade
    quizzesPercentage = quizTotal


#5
tests = testChoice
if tests == 0:
    percentage4 = testPercent
    earnedPercentage = testGrade
    testsPercentage = testTotal
    
else:
    percentage4 = testPercent
    earnedPercentage = testGrade
    testsPercentage = testTotal

#6 
finalExam = finalChoice
if finalExam == 0:
    percentage5 = finalPercent
    earnedPercentage = finalGrade
    testsPercentage = finalTotal
    
else:
    percentage5 = finalPercent
    earnedPercentage = finalGrade
    finalExamPercentage = finalTotal
    
totalPercentage = attendancePercentage + assignmentPercentage + quizzesPercentage + testsPercentage + finalExamPercentage


print ("Your final total percentage is", totalPercentage)

if totalPercentage >= 90:
    outputGrade = 'A'
    print ("Your grade is 'A'")
elif totalPercentage >= 80:
    outputGrade = 'B'
    print ("Your grade is 'B'")
elif totalPercentage >=70:
    outputGrade = 'C'
    print ("Your grade is 'C'")
elif totalPercentage >= 60:
    outputGrade = 'D'
    print ("Your grade is 'D'")
else:
    outputGrade = 'F'
    print ("Your grade is 'F'")

#write to file below 

final = open("final.txt", "w")
final.write(outputGrade)
final.close()


