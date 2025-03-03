import subprocess, re

FILE = "frontend/README.md"

# Versionsnummer hochzählen
output = ""
with open(FILE, 'r', encoding='utf-8') as file:
    for line in file:
        match = re.search(r'- Version \s*(\d+\.\d+)', line)
        if match:
            output = float(match.group(1)) + 0.01
            break

command_string = (f"sed -i '/Version/c- Version {output}' {FILE}; ", # Versionsnummer ersetzen
                   "sed -i '/Struktur/,$d' {FILE}; ",
                   "echo -e '## Struktur\n```' >> {FILE}; ",
                   "tree >> {FILE}; ",
                   "echo -e '```\n' >> {FILE}")
subprocess.run(command_string, shell=True)

