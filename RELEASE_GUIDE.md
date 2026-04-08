# Release and Signing Guide

To use the automated release workflow, you need to set up several secrets in your GitHub repository.

## 1. Prepare your Keystore
If you already have a `.jks` or `.keystore` file, you need to encode it to Base64 to store it in GitHub Secrets.

Run this command in your terminal:
```bash
base64 -w 0 your_keystore_file.jks > keystore_base64.txt
```
Copy the content of `keystore_base64.txt`.

## 2. Add GitHub Secrets
Go to your repository on GitHub: **Settings > Secrets and variables > Actions > New repository secret**.

Add the following secrets:

| Secret Name | Description |
|-------------|-------------|
| `RELEASE_KEYSTORE` | The Base64 encoded content of your keystore file. |
| `KEYSTORE_PASSWORD` | The password for your keystore. |
| `KEY_ALIAS` | The alias for your signing key. |
| `KEY_PASSWORD` | The password for your signing key. |

## 3. Triggering a Release
The workflow is triggered when you push a tag that starts with `v`.

```bash
git tag v1.0.0
git push origin v1.0.0
```

The workflow will:
1. Build and sign the release APK.
2. Generate a changelog from the commit messages since the last tag.
3. Create a new GitHub Release with the APK attached.
