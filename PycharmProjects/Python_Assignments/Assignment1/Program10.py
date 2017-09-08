sentence=input("Enter a Sentence : ")
line=sentence.split(" ")
print(" ".join(sorted(set(line))))