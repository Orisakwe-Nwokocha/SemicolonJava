num = int(input("Enter a number:\n"))

if num <= 100:
	print("Your bill is free")

elif num > 100 and num <= 200:
	price1 = 10 * (num - 100)
	print(f"Your bill is {price1}")

elif num > 200:
	price3 = ((num - 200) * 20) + (100) * 10
	print(f"Your bill is {price3}")