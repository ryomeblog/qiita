import base64
import json
import glob


def split_text(text, split_byte_size, charcode='utf-8'):
    bytes_text = text.encode(charcode)
    head = bytes_text[:split_byte_size].decode(charcode, errors='ignore')
    tail = text[len(head):]

    if tail == text:
        return []

    split_tail = split_text(tail, split_byte_size)

    result = []
    result.append(head)
    result.extend(split_tail)

    return result


if __name__ == "__main__":
    # 設定取得
    setting = json.load(open('./setting.json', "r", encoding="utf-8"))
    if setting["setting"] == "z2t":
        input_path = str(setting["input"]) + "in.zip"
        with open(input_path, "rb") as f:
            s = base64.b64encode(f.read())
        split_text = split_text(s.decode(), int(setting["byte"]))
        for index, text in enumerate(split_text):
            f = open(str(setting["output"]) + "file" + str(index) + ".txt", 'w', encoding=setting["encoding"])
            f.write(text)
            f.close()
    elif setting["setting"] == "t2z":
        file_txt = ""
        for index, filepath in enumerate(glob.glob(str(setting["input"]) + "*")):
            with open(str(setting["input"]) + "file" + str(index) + ".txt", "r", encoding=setting["encoding"]) as f:
                file_txt += f.read()
        output_path = str(setting["output"]) + "out.zip"
        with open(output_path, "wb") as f:
            f.write(base64.b64decode(file_txt))
