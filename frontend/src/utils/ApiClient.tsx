class ApiClient {
  static get<T>(path: string): Promise<T> {
    return fetch(path)
      .then(res => {
        if (!res.ok) {
          throw new Error(res.statusText);
        }
        return res.json().then(data => data as T);
      }
    );
  }
}

export default ApiClient;
