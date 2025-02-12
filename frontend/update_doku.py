import subprocess, re

# Versionsnummer hochzählen
with open("README.md", 'r', encoding='utf-8') as file:
    for line in file:
        match = re.search(r'- Version \s*(\d+\.\d+)', line)
        if match:
            output = float(match.group(1)) + 0.01
            break
subprocess.run(f"sed -i '/Version/c- Version {output}' README.md", shell=True)

# Datei-tree aktualisieren
subprocess.run("sed -i '/Struktur/,$d' README.md", shell=True) # alten tree löschen
subprocess.run("echo -e '## Struktur\n```' >> README.md", shell=True)
subprocess.run("tree >> README.md", shell=True)
subprocess.run("echo -e '```\n' >> README.md", shell=True)

