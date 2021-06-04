# Shift Cipher
Cipher Shifting A-Z characters by 3 characters for encoding and decoding e.g. A=0 and 6=G
<table style="width:100%">
  <tr>
    <td>A</td>
    <td>B</td>
    <td>C</td>
    <td>D</td>
    <td>E</td>
    <td>F</td>
    <td>G</td>
    <td>H</td>
    <td>...</td>
    <td>Z</td>
  </tr>
  <tr>
    <td>0</td>
    <td>1</td>
    <td>2</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
    <td>6</td>
    <td>7</td>
    <td>...</td>
    <td>25</td>
   </tr>
</table>

<table style="width:100%">
  <tr>
    <th>Encoding example</th>
    <th>Decoding example</th>
  </tr>
  <tr>
    <td>
      <table>
        <tr>
          <th>String</th>
          <th>Cipher value</th>
          <th>Shift +3</th>
          <th>Encoded Text</th>
        </tr>
        <tr>
          <td>HELLO</td>
          <td>7 4 11 11 14</td>
          <td>10 7 14 14 17</td>
          <td>KHOOR</td>
        </tr>
      </table>  
    </td>
    <td>
      <table>
        <tr>
          <th>String</th>
          <th>Cipher value</th>
          <th>Shift -3</th>
          <th>Decoded Text</th>
        </tr>
        <tr>
          <td>KHOOR</td>
          <td>10 7 14 14 17</td>
          <td>7 4 11 11 14</td>
          <td>HELLO</td>
        </tr>
      </table>  
    </td>
   </tr>
</table>

# Run using Actions
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
