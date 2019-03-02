def get_user():
    allUsers = []
    filename = "user.txt"
    with open(filename) as file:
        for line in file:
            allUsers.append({"user": line})
    return allUsers

def add_user(user):
    filename = "user.txt"
    with open(filename, "a") as file:
        file.write(user + "\n")