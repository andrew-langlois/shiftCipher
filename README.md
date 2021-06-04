# Shift Cipher
Cipher Shifting A-Z characters by 3 characters for encoding and decoding e.g. H=7 and 10=K
<table>
  <tr>
    <td>A</td>
    <td>B</td>
    <td>C</td>
    <td>D</td>
    <td>E</td>
    <td>F</td>
    <td>G</td>
    <td><B>H</B></td>
    <td>I</td>
    <td>J</td>
    <td><B>K</B></td>
    <td>L</td>
    <td>M</td>
    <td>N</td>
    <td>O</td>
    <td>P</td>
    <td>Q</td>
    <td>R</td>
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
    <td><B>7</B></td>
    <td>8</td>
    <td>9</td>
    <td><B>10</B></td>
    <td>11</td>
    <td>12</td>
    <td>13</td>
    <td>14</td>
    <td>15</td>
    <td>16</td>
    <td>17</td>
    <td>...</td>
    <td>25</td>
   </tr>
</table>

<table>
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
          <th>Encoded</th>
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
          <th>Decoded</th>
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
