# Security Policy

## Reporting a vulnerability

Do not publish exploitable vulnerability details, credentials, tokens, private keys or sensitive data in a public issue.

For this portfolio repository, use GitHub's private vulnerability reporting feature if it is enabled. Otherwise, contact the repository maintainer through the contact options available on the GitHub profile.

## Security expectations for examples

- Use synthetic documents and test data only.
- Keep secrets in environment variables or an approved secrets manager.
- Validate file type, size and content before ingestion.
- Scan uploaded files before parsing.
- Enforce tenant and document ACL filters during retrieval.
- Treat prompts and retrieved content as untrusted input.
- Apply data minimization, retention and deletion policies.
- Log security-relevant events without logging secrets or unnecessary personal data.

These examples are educational and are not a security certification or production security guarantee.
