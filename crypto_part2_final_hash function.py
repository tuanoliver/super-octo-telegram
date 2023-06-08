def this_is_hash_function_for_program(this_is_message: str) -> str:
    # create some three variables
    this_is_hash_value_for_hash_function = 0
    this_is_prime_for__hash_function  = 31   #prime number
    this_is_mod_for_hash_function = 1e9 + 7 #large prime number to reduce hash collision

    # go over every character in the message
    for char in this_is_message:
        # make the new hash value
        this_is_hash_value_for_hash_function = (this_is_hash_value_for_hash_function * this_is_prime_for__hash_function + ord(char)) % this_is_mod_for_hash_function

    # Return the hash value as a string
    return str(int(this_is_hash_value_for_hash_function))


X = "Leave the pen drive in Room 18.103 at ECU."
D = this_is_hash_function_for_program(X)
print("Message digest:", D)


#https://leetcodethehardway.com/tutorials/basic-topics/mod
#https://stackoverflow.com/questions/27522626/hash-function-in-python-3-3-returns-different-results-between-sessions
#https://docs.python.org/3/tutorial/controlflow.html#defining-functions
#https://www.geeksforgeeks.org/modulo-power-for-large-numbers-represented-as-strings/
#https://chat.openai.com/
#https://www.w3schools.com/python/ref_func_ord.asp
# https://www.freecodecamp.org/news/python-convert-string-to-int-how-to-cast-a-string-in-python/
# https://realpython.com/convert-python-string-to-int/



