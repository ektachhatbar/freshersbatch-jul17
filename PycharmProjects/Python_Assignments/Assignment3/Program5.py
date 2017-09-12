import datetime
if datetime.datetime.now().hour < 12:
    print('Good morning.')
elif 12 <= datetime.datetime.now().hour < 18:
     print('Good afternoon.')
else:
    print('Good evening.')