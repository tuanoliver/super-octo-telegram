from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256
from Crypto.PublicKey import RSA

# create Alice's  key for digital signature
this_is_alice_key_for_program = RSA.generate(2048)
# format the key
this_is_private_key = this_is_alice_key_for_program.export_key()

# make the key to number
private_key_number_of_alice = int.from_bytes(this_is_private_key, byteorder='big')

# Print the key for alice
print("alice key :",private_key_number_of_alice)


# take  message and  put it to bytes
this_is_message_digest = b"867022042"      

# take the message become hash
this_is_hash_for_message = SHA256.new(this_is_message_digest)

# Alice use her private key to sign the message
this_is_signature = pkcs1_15.new(this_is_alice_key_for_program).sign(this_is_hash_for_message)

# Bob use Alice's public key to authenticate the signature
try:
    pkcs1_15.new(this_is_alice_key_for_program.publickey()).verify(this_is_hash_for_message, this_is_signature)
    print("digital signature's legitimate")
except (ValueError, TypeError):
    print("digital signature not legitimate")


#https://pycryptodome.readthedocs.io/en/latest/src/public_key/rsa.html
#https://stackoverflow.com/questions/9197507/saving-rsa-keys-to-a-file-using-pycrypto
# https://stackoverflow.com/questions/50509017/how-is-int-from-bytes-calculated
# https://docs.python.org/3/library/stdtypes.html
# https://pycryptodome.readthedocs.io/en/latest/src/hash/sha256.html
# https://pycryptodome.readthedocs.io/en/latest/src/signature/signature.html
# https://pycryptodome.readthedocs.io/en/latest/src/signature/pkcs1_v1_5.html
# https://chat.openai.com/
# https://stackoverflow.com/questions/54593320/validationerror-or-typeerror-valueerror-exceptions
# https://stackoverflow.com/questions/40140094/try-and-except-typeerror
