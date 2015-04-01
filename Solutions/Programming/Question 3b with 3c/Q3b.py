import datetime

dayNames = ["First","Second","Third","Fourth","Fifth","Sixth", "Seventh" ,"Eighth","Nineth","Tenth" ,"Eleventh","Twelfth","Thirteenth","Fourteenth","Fifteenth","Sixteenth","Seventeenth","Eighteenth","Nineteenth","Twentieth","Twenty-first","Twenty-second", "Twenty-third", "Twenty-four","Twenty-fifth","Twenty-sixth", "Twenty-seventh", "Twenty-eighth", "Twenty-ninth","Thirtieth","Thirty-first"]
monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
quarter = ["Q1", "Q2", "Q3", "Q4"]
			

def func():
    file = open("result.txt","w")
    print("File has been opened")


    firstDate = datetime.date(2000,1,1)
    endDate = datetime.date(2004,12,31)

    firstDateText = str(firstDate) + "," + monthNames[firstDate.month - 1] + "," + str(firstDate.strftime("%j")) + "," + str(firstDate.strftime("%A")) + "," + str(quarter[(firstDate.month - 1)//3]) + "," + dayNames[int(firstDate.strftime("%d")) - 1] + " of " + monthNames[firstDate.month - 1]
    file.write(firstDateText)
    file.write("\n")
    file.flush()
    
    while firstDate != endDate:
        firstDate += datetime.timedelta(days = 1) 
        nextDateText = str(firstDate) + "," + monthNames[firstDate.month - 1] + "," + str(firstDate.strftime("%j")) + "," + str(firstDate.strftime("%A")) + "," + str(quarter[(firstDate.month - 1)//3]) + "," + dayNames[int(firstDate.strftime("%d")) - 1] + " of " + monthNames[firstDate.month - 1]
        file.write(nextDateText)
        file.write("\n")
        file.flush()
    
    file.close()
    print("File has been closed")

    
func()
