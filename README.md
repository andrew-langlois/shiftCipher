# Shift Cipher
Cipher Shifting A-Z characters by 3 character for encoding and decoding

Please run the Maven pom.xml file using the Maven CI Action which builds the application and runs the JUnit Test Cases resulting in the following output e.g.:

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running Ciphers.ShiftCipherPlus3Test

Start with: HELLO

- Encode Message to numbers: HELLO => [ 7 4 11 11 14 ]

- Increment the value by 3:  [ 7 4 11 11 14 ] => [ 10 7 14 14 17 ]

- Numbers back into letters: [ 10 7 14 14 17 ] => KHOOR

Encoded to: KHOOR

- Decode Message to numbers: KHOOR => [ 10 7 14 14 17 ]

- Decrement the value by 3:  [ 10 7 14 14 17 ] => [ 7 4 11 11 14 ]

- Numbers back into letters: [ 7 4 11 11 14 ] => HELLO

Decoded to: HELLO
