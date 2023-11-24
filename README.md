# vivatech-palindrome-assignment
creating three button input, submit, download

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Input</title>
    <style>
        section
        {
           
            display: flex;
            flex-direction: column;
            justify-content: space-around;
        }
        
        div{
            margin-top:30px;
        }
        
    </style>
</head>
<body>

    <Section>
        <div>
            <label for="pal">Input</label>
            <input type="text" id="pal">
        </div>
        <div>
            <input type="submit" value="Submit" style="background-color: blue; color:white; height: 30px; border-radius: 20px; margin-right: 30px;">
            <input type="submit" value="Download" style="background-color: brown; color:white; height: 30px; border-radius: 20px;">
        </div>
       
    </Section>
    
</body>
</html>
