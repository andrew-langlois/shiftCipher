# Shift Cipher
Cipher Shifting A-Z characters by 3 character for encoding and decoding

# Run using Maven CI Action
Please run the Maven pom.xml file using the Maven CI Action Workflow called "Java CI with Maven". This Action builds the application and runs the JUnit Test Cases and the build and unit test ouput can be seen in console output section "Step 3 - Have GitHub Actions Build Maven Project". The JUnit Test Cases result in the following output e.g.:

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
