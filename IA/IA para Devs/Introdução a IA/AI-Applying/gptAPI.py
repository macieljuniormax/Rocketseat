from openai import OpenAI

client = OpenAI()

completion = client.completions.create(
    model="gpt-5-nano",
    max_tokens=200,
    messages=[
        {"role": "system", "content": "VOcê é um experiente programador. Retorne apenas código limpo e de qualidade."},
        {"role": "user", "content": "Escreva um código de Hello, World em python"}
    ],
)

print(completion.choices[0].message.content)
