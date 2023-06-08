from math import gcd
from Crypto.Util.number import inverse

# make prime interger for p and q
this_is_p = 23
this_is_q = 29

# do mathematic of calculation for n and phi
this_is_n = this_is_p * this_is_q
this_is_phi = (this_is_p- 1) * (this_is_q - 1)

# make the public and private
this_is_e = 65537
this_is_d = inverse(this_is_e, this_is_phi)

# make  secret key for encode
K = "this is the key"

# change   secret key  to number
this_is_key_int_for_program = int.from_bytes(K.encode(), 'big')

# encode  secret key by RSA
this_is_ciphertext = pow(this_is_key_int_for_program, this_is_e, this_is_n)

# decode  secret key by RSA
this_is_decrypted_key = pow(this_is_ciphertext, this_is_d, this_is_n)

# Print the results
print("Key K:", K)
print("this is Public key for program:", (this_is_e, this_is_n))
print("this is Private key for program:", (this_is_d, this_is_n))
print("this is Encrypted key for program:", this_is_ciphertext)
print("this is Decrypted key for program :", this_is_decrypted_key)

#https://docs.python.org/3/library/math.html
#https://docs.python.org/3/library/stdtypes.html#int.from_bytes
#https://pycryptodome.readthedocs.io/en/latest/src/util/util.html
#https://chat.openai.com/
#https://docs.python.org/3/library/functions.html#pow


